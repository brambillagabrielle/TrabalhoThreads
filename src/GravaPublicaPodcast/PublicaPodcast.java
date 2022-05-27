package GravaPublicaPodcast;

import java.util.concurrent.ArrayBlockingQueue;

/**
* Classe PublicaPodcast para representar a thread de publicação de um podcast
* gravado.
* 
* @author Gabrielle Brambilla (20201PF.CC0190)
*/
public class PublicaPodcast extends Thread {
    
    private ArrayBlockingQueue<String> getFilaPublicacao;
    private String assuntoGravado;
    
    public PublicaPodcast(ArrayBlockingQueue<String> getFilaPublicacao) {
        this.getFilaPublicacao = getFilaPublicacao;
        this.assuntoGravado = "";
    }
    
    public ArrayBlockingQueue<String> getFilaPublicacao() {
        return getFilaPublicacao;
    }

    public void setAssuntoGravado(String assuntoGravado) {
        this.assuntoGravado = assuntoGravado;
    }

    public String getAssuntoGravado() {
        return assuntoGravado;
    }
    
    public void mostraPublicacao(int episodio) {
        System.out.println("Publicado: Ep #" + episodio + " - " + getAssuntoGravado());
    }
    
    /**
    * Método run pertencente à classe Thread, com o código que é executado em
    * paralelo. Nesse caso o código pega podcasts gravados que foram enviados
    * para a fila BlockingQueue (fila de publicação) e publica os episódios.
    */
    @Override
    public void run() {
        
        int episodio = 0;
        
        try {
            
            while (true) {
                
                if (!getFilaPublicacao().isEmpty()) {
                    
                    episodio++;
                    setAssuntoGravado(getFilaPublicacao().take());
                    mostraPublicacao(episodio);
                    
                }
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
