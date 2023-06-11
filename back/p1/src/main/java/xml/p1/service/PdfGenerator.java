package xml.p1.service;


import org.springframework.stereotype.Service;
import org.w3c.dom.Node;
import xml.p1.transformers.PDFTransformer;
import xml.p1.repository.PatentRepository;

import java.io.ByteArrayOutputStream;

@Service
public class PdfGenerator {

    private final PatentRepository patentRepository;
    private final PDFTransformer pdfTransformer;

    public PdfGenerator(PatentRepository patentRepository, PDFTransformer pdfTransformer) {
        this.patentRepository = patentRepository;
        this.pdfTransformer = pdfTransformer;
    }

    public ByteArrayOutputStream generatePdfOrHtml(String format, String brZahteva) throws Exception {
        String documentId = brZahteva + ".xml";
        Node file = this.patentRepository.getFileAsNode(documentId);
        return this.pdfTransformer.parseToPdf(format, file);
    }
}
