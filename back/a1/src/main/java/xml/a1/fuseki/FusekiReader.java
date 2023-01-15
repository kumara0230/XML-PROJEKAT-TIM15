package xml.a1.fuseki;

import org.apache.commons.text.StringSubstitutor;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.RDFNode;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class FusekiReader {
    private static final String QUERY_FILEPATH = "src/main/resources/rdf/sparql.rq";

    private FusekiReader() {
    }

    public static ArrayList<String> executeQuery(Map<String, String> params) throws IOException {
        FusekiAuthenticationUtilities.ConnectionProperties conn = FusekiAuthenticationUtilities.loadProperties();
        String sparqlQueryTemplate = readFile(QUERY_FILEPATH, StandardCharsets.UTF_8);
        System.out.println("Query: " + sparqlQueryTemplate);

        String sparqlQuery = StringSubstitutor.replace(sparqlQueryTemplate, params, "{{", "}}");
        System.out.println("Query: " + sparqlQuery);

        QueryExecution query = QueryExecutionFactory.sparqlService(conn.queryEndpoint, sparqlQuery);
        ResultSet results = query.execSelect();

        String varName;
        RDFNode varValue;

        ArrayList<String> found = new ArrayList<>();   // test

        while (results.hasNext()) {
            // A single answer from a SELECT query

            QuerySolution querySolution = results.next();
            Iterator<String> variableBindings = querySolution.varNames();
            // Retrieve variable bindings
            while (variableBindings.hasNext()) {
                varName = variableBindings.next();
                varValue = querySolution.get(varName);
                System.out.println(varName + ": " + varValue);
                if (varName.contains("Broj_prijave")) {    // test
                    String value = varValue.toString();
                    found.add(value);
                }
            }
        }
        ResultSetFormatter.outputAsXML(System.out, results);
        query.close();
        return found;
    }

    public static String readFile(String path, Charset encoding) throws IOException {
        byte[] encodede = Files.readAllBytes(Paths.get(path));
        return new String(encodede, encoding);
    }
}
