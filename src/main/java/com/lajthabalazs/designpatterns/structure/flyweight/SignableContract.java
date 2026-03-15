package com.lajthabalazs.designpatterns.structure.flyweight;

public class SignableContract {

    private final Contract template;
    private final String assignedUser;
    private String signature;

    public SignableContract(Contract template, String assignedUser) {
        this.template = template;
        this.assignedUser = assignedUser;
    }

    public String displayContract() {
        if (signature == null) {
            return String.format("""
                    Contract text: %s
                    Assigned to: %s
                    Status: Signature needed""", template.getText(), assignedUser);
        } else {
            return String.format("""
                    Contract text: %s
                    Assigned to: %s
                    Status: Signed
                    Signature; %s""", template.getText(), assignedUser, signature);
        }
    }

    public void sign(String signature) {
        this.signature = signature;
    }
}
