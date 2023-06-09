package xml.a1.service;


import org.springframework.stereotype.Service;
import org.w3c.dom.Node;
import xml.a1.repository.AutorskaRepository;
import xml.a1.transformers.PDFTransformer;

import java.io.ByteArrayOutputStream;

@Service
public class PdfGenerator {

    private final AutorskaRepository autorskaRepository;
    private final PDFTransformer pdfTransformer;

    public PdfGenerator(AutorskaRepository autorskaRepository, PDFTransformer pdfTransformer) {
        this.autorskaRepository = autorskaRepository;
        this.pdfTransformer = pdfTransformer;
    }

    public ByteArrayOutputStream generatePdfOrHtml(String format, String brZahteva) throws Exception {
        String documentId = brZahteva + ".xml";
        Node file = this.autorskaRepository.getFileAsNode(documentId);
        return this.pdfTransformer.parseToPdf(format, file);
    }
}
