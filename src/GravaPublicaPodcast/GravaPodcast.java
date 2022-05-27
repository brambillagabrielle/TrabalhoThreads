package GravaPublicaPodcast;

import java.util.concurrent.ArrayBlockingQueue;

/**
* Classe GravaPodcast para a thread de gravação do podcast. Gera um assunto
* para depois ser publicado, demorando 1 segundo para gravar cada um.
* 
* @author Gabrielle Brambilla (20201PF.CC0190)
*/
public class GravaPodcast extends Thread {
    
    private ArrayBlockingQueue<Podcast> filaPublicacao;
    private Podcast podcast;
    
    public GravaPodcast(ArrayBlockingQueue<Podcast> filaPublicacao, Podcast podcast) {
        this.filaPublicacao = filaPublicacao;
        this.podcast = podcast;
    }
    
    public ArrayBlockingQueue<Podcast> getFilaPublicacao() {
        return filaPublicacao;
    }

    public Podcast getPodcast() {
        return podcast;
    }

    public void setPodcast(Podcast podcast) {
        this.podcast = podcast;
    }
    
    /**
    * Método geraAssunto para gerar assuntos para o podcast a partir de dois
    * grupos de strings que se complementam. Usa índices randômicos para sortear
    * os pares.
    * 
    * @return par de assuntos sorteados dos vetores gerando uma string
    */
    public String geraAssunto() {
        
        String assunto1[] = {"História dos ", "A grande querra dos ", "Top 10 filmes sobre ",
                    "Resenha: Amor nos tempos dos ", "O que comem os ", "A verdade sobre os ",
                    "Morte e vida dos "};
        String assunto2[] = {"lambaris", "cantores de sertanejo", "agiotas", "piratas",
                    "cupins", "jogares de free fire", "programadores de Java"};
        
        return(assunto1[(int)Math.floor(Math.random()*7)]
                        + assunto2[(int)Math.floor(Math.random()*7)]);
    }
    
    /**
    * Método run pertencente à classe Thread, com o código que é executado em
    * paralelo. Nesse caso o código "importa" os podcasts gravados para a fila
    * BlockingQueue (fila de publicação).
    */
    @Override
    public void run() {
        
        int episodio = 0;
        
        while (getFilaPublicacao().remainingCapacity() >= 1 && episodio < 10) {
                
            try {
                
                episodio++;
                this.podcast.setAssunto(geraAssunto());
                this.podcast.setEpisodio(episodio);
                
                getFilaPublicacao().put(podcast);
                
                Thread.sleep(1000);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
    }
    
}
