package io.bootify.my_oracle_app.incidente;


public enum Tecnologia {
    DOS_G("2G"), TRES_G("3G"), CUATRO_G("4G"), CINCO_G("5G");

    private String value;

    private Tecnologia(String value) {
        this.value = value;
    }
}
