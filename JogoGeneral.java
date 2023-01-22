
import java.io.Serializable;

public class JogoGeneral implements Serializable{
    private Dado[] dados = new Dado[5];
    private int[] jogadas = new int[13];

    public JogoGeneral() {
        
    }
    public Dado[] getDados() {
        return dados;
    }
    public void rolarDados (){ 
        for (int i = 0; i < 5; i++) {
            dados[i] = new Dado();
        }
    }
    public void setJogadas(int[] jogadas) {
        this.jogadas = jogadas;
    }
    
}
