package xml.z1.service;

import org.springframework.stereotype.Service;
import org.w3c.dom.Node;
import xml.z1.repository.ZigoviRepository;
import xml.z1.transformer.PDFTransformer;

import java.io.ByteArrayOutputStream;

@Service
public class PdfGenerator {

    private final ZigoviRepository zigoviRepository;
    private final PDFTransformer pdfTransformer;

    public PdfGenerator(ZigoviRepository zigoviRepository, PDFTransformer pdfTransformer) {
        this.zigoviRepository = zigoviRepository;
        this.pdfTransformer = pdfTransformer;
    }

    public ByteArrayOutputStream generatePdfOrHtml(String format, String brZahteva) throws Exception {
        String documentId = brZahteva + ".xml";
        Node file = this.zigoviRepository.getFileAsNode(documentId);
        return this.pdfTransformer.parseToPdf(format, file);
    }
}
