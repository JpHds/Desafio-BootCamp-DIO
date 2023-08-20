import java.util.ArrayList;
import java.util.List;

public class Iphone extends Application {
    private List<Application> availableApps;

    public Iphone() {
        availableApps = new ArrayList<>(List.of(new Navigator(), new Contacts(), new Player()));
    }

    public void close(Application app) {
        if(app.openned) {
            System.out.println("Encerrando o " + app + "...");
            app.openned = false;
        } else {
            System.out.println("O " + app + " já está fechado!");
        }
    }

    public void open(Application app) {
        if(!app.openned && availableApps.contains(app)) {
            System.out.println("Executando o " + app + "...");
            app.openned = true;
        } else if(app.openned){
            System.out.println("O " + app + " já está em execução!");
        } else {
            System.out.println("ERRO: Aplicativo não disponível no dispositivo!");
        }
    }
   
}
