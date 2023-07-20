package enums;

public enum Domains {
    GMAIL("gmail"),
    YANDEX("yandex"),
    MAIL("mail");

    private final String domain;

    Domains(String domain) {
        this.domain = domain;
    }

    public String getDomain() {
        return domain;
    }
}
