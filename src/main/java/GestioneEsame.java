
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tss
 */
public class GestioneEsame {

    static String nomeEsame;
    static int[] listavoti;
    static String[] listacognomi;
    static String[] listanomi;
     static int soglia=60;
     static String   msg_ko;
     
     static String   msg_ok ;
     

        
        
            
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //fase 1 richiamo preparaesame;
        preparaEsame();
        // fase 2 inizio sessione
        sessioneEsame();
        //fase 3 correzione e assegnazone voti 
        correzioneEsame();
        // fase 4 preparazione tabelloni risultati 
        visTabellone();

    }

    static void preparaEsame() {
        //inizializza esame ovvero crea registro nome, cognome ecc.

        nomeEsame = JOptionPane.showInputDialog("inserisci nome esame");
        int quanti = utils.askInt("inserisci max numero alunni", 1, 100);
        //creo registro

        listanomi = new String [quanti];
        listacognomi = new String [quanti];
        listavoti = new int [quanti];
        
        soglia =  utils.askInt("voto minimo per sufficienza", 1, 100);
        msg_ko = JOptionPane.showInputDialog("dimmi il testo quando bocciato");
        msg_ok = JOptionPane.showInputDialog("dimmi il testo quando promosso");
        
    }

    private static void sessioneEsame() {
        //caricare il registro con i partecipanti
        for (int i = 0; i < listacognomi.length; i++) {

            listacognomi[i] = JOptionPane.showInputDialog("dimmi il cognome" + (1 + i) + "di" + listanomi.length);
           
           
            listacognomi[i]=utils.setFirstCapitalize(listacognomi[i]) ;
            listanomi[i] = JOptionPane.showInputDialog("dimmi il nome"); 
            listanomi[i]=utils.setFirstCapitalize(JOptionPane.showInputDialog("dimmi il nome")) ;
          
            
                               
        }

    }

    private static void correzioneEsame() {
//docente fornisce esami di carta con voto
//ogni esame ha sopra nome e cognome
//caricamento voti
        for (int i = 0; i< listacognomi.length; i++) {
            String nom = listanomi[i];
            String cog = listacognomi[i];
            String msg = "inserisci il voto di" + nom + " " + cog;
            listavoti[i] = utils.askInt(msg, 0, 100);

        }
        
    }



    private static void visTabellone() {
        

        String ris = "VOTAZIONE\n..............\n"+ nomeEsame.toUpperCase()+ "\n.............";
       
        
        for (int i = 0; i< listacognomi.length; i++) {
            // guerrini luca - =73
            //rossi mario -voto =90
             ris = ris + listacognomi[i] + " " + listanomi[i];
            ris += " -  voto =  " + listavoti[i];
                
      
            if (listavoti[i]>=soglia){//caso ok
                
                ris+= ""+ msg_ok + "promosso";
           
            }
                     
            else{//caso ko
                ris = "  ";
            }
        JOptionPane.showMessageDialog(null, ris);
    }

    
}
}


