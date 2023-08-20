import interfaces.IContacts;


public class Contacts extends Application implements IContacts{

    public Contacts() {
        super.openned = false;
    }


    @Override
    public void call() {
        if(super.openned) {
        System.out.println("Ligando...");
        } else {
            System.out.println("ERRO: Abra o App Contatos!");
        }
    }

    @Override
    public void answer() {
        System.out.println("Atendendo ligação...");
    }

    @Override
    public void startVoiceMail() {
        if(super.openned) {
            System.out.println("Iniciando Correio de voz...");
        } else {
            System.out.println("ERRO: Abra o App Contatos!");
        }
    }

    @Override
    public String toString() {
        return "Contatos";
    }
    
}
