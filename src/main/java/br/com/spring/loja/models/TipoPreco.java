package br.com.spring.loja.models;

public enum TipoPreco {
    EBOOK, IMPRESSO, COMBO;

    public int getNumero(){
        return this.ordinal();
    }

    public static TipoPreco getTipo(int i) {
        for (TipoPreco p: TipoPreco.values()) {
            if(i == p.ordinal()) {
                return p;
            }
        }
        return null;
    }
}
