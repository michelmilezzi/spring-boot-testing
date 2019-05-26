package br.com.michelmilezzi.DemoApp.service.impl;

import br.com.michelmilezzi.DemoApp.domain.Invoice;
import br.com.michelmilezzi.DemoApp.domain.Tax;
import br.com.michelmilezzi.DemoApp.exception.InvalidInvoiceException;
import br.com.michelmilezzi.DemoApp.service.TaxService;
import br.com.michelmilezzi.DemoApp.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private TaxService taxService;

    @Override
    public void calculateTaxes(Invoice invoice) {
        Tax tax = taxService.findByRatioLessThanEqual(invoice.getTotal());
        if (tax == null) {
            throw new NullPointerException("Proper Tax not found");
        }
        invoice.setTax(tax.getValue().multiply(invoice.getTotal()));
    }

    @Override
    public Double calculateSomethingComplex(Invoice invoice) {
        return 10.2D;
    }

    @Override
    public void validateInvoice(Invoice invoice) throws InvalidInvoiceException {
        throw new InvalidInvoiceException("Invalid Invoice. Ref.: " + invoice);
    }

}
