package com.lajthabalazs.designpatterns.structure.flyweight;

import java.util.ArrayList;
import java.util.List;

public class ContractStore {
    private final List<SignableContract> contracts = new ArrayList<>();
    private final List<Contract> templates = new ArrayList<>();

    public SignableContract createContract(String text, String assignedUser) {
        var template = createOrLoad(text);
        SignableContract newContract = new SignableContract(template, assignedUser);
        contracts.add(newContract);
        return newContract;
    }

    private Contract createOrLoad(String text) {
        var existingTemplate = templates.stream()
                .filter(template -> text.equals(template.getText()))
                .findFirst();
        if (existingTemplate.isEmpty()) {
            Contract newTemplate = new Contract(text);
            templates.add(newTemplate);
            return newTemplate;
        } else {
            return existingTemplate.get();
        }
    }

    public int getTemplateCount() {
        return templates.size();
    }
}
