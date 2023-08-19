import java.util.ArrayList;
import java.util.List;

public class Iphone extends Aplicativo implements Contatos, Navegador, ReprodutorMusical  {

    private boolean reprodutorAberto;
    private boolean tocando;
    private String musicaSelecionada;
    private boolean navegadorAberto;
    private boolean iPhoneLigado;
    private int abasAbertas = 0;
    private boolean contatosAberto;

    private static final String IPHONE_DESLIGADO = "O iPhone está desligado!";

    private static final String NAVEGADOR_FECHADO = "O navegador está fechado!";

    private static final String REPRODUTOR_FECHADO = "O reprodutor está fechado!";

    private static final String CONTATOS_FECHADO = "O App Contatos está fechado!";

    private List<String> apps = new ArrayList<>(List.of("Contatos", "Navegador", "Reprodutor Musical"));

    private List<String> appsAbertos = new ArrayList<>();


    private boolean verificarApp(String app) {
        if(appsAbertos.contains(app)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    void abrirApp(String app) {
        if(!appsAbertos.contains(app) && apps.contains(app)) {
            appsAbertos.add(app);
            System.out.println("Abrindo o aplicativo " + app);
        } else if (appsAbertos.contains(app)) {
            System.out.println("O aplicativo " + app + " já está aberto!");
        } else {
            System.out.println("Seu aparelho não contém o aplicativo informado!");
        }
    }

    @Override
    void fecharApp(String app) {
        if(appsAbertos.contains(app)) {
            appsAbertos.remove(app);
        } else {
            System.out.println("O aplicativo " + app + " já está fechado!");
        }
    }

    public void ligarIphone() {
        if(!iPhoneLigado) {
            System.out.println("Ligando o iPhone...");
            iPhoneLigado = true;
        } else {
            System.out.println(IPHONE_DESLIGADO);
        }
    }

    public void desligarIphone() {
        if(iPhoneLigado) {
            iPhoneLigado = false;
            System.out.println("Desligando o iPhone...");
        } else {
            System.out.println(IPHONE_DESLIGADO);
        }
    }


    @Override
    public void tocar() {
        if (musicaSelecionada!=null && iPhoneLigado && verificarApp("Reprodutor Musical") && !tocando) {
            tocando = true;
            System.out.println("Tocando " + getMusicaSelecionada() + "!");
        } else if (!iPhoneLigado){
            System.out.println(IPHONE_DESLIGADO);
        }else if(!appsAbertos.contains("Reprodutor Musical")){
            System.out.println(REPRODUTOR_FECHADO);
        } else if (musicaSelecionada == null){
            System.out.println("Nenhuma música selecionada para tocar!");
        } else {
            System.out.println("O reprodutor já está tocando!");
        }
    }

    @Override
    public void pausar() {
        if (iPhoneLigado && verificarApp("Reprodutor Musical") && tocando) {
            tocando = false;
            System.out.println("Reprodutor pausado!");
        } else if(!iPhoneLigado) {
            System.out.println(IPHONE_DESLIGADO);
        } else if(!appsAbertos.contains("Reprodutor Musical")){
            System.out.println(REPRODUTOR_FECHADO);
        } else {
            System.out.println("O reprodutor não está tocando!");
        }
    }

    @Override
    public void selecionarMusica(String musica) {
        if (iPhoneLigado && verificarApp("Reprodutor Musical")) {
            System.out.println("Música selecionada: " + musica);
            musicaSelecionada = musica;
        } else if (!iPhoneLigado){
            System.out.println(IPHONE_DESLIGADO);
        } else {
            System.out.println("Impossível tocar a música. O reprodutor está fechado!");
        }
    }

    @Override
    public void exibirPagina(int pag) {
        if(iPhoneLigado && verificarApp("Navegador") && pag > 0 && pag <= abasAbertas) {
            System.out.println("Exibindo a página " + pag);
        } else if (!iPhoneLigado) {
            System.out.println(IPHONE_DESLIGADO);
        } else if (appsAbertos.contains("Navegador")) {
            System.out.println(NAVEGADOR_FECHADO);
        } else {
            System.out.println("A página mencionada não existe!");
        }
    }

    @Override
    public void adicionarNovaAba() {
        if(iPhoneLigado && verificarApp("Navegador")) {
            System.out.println("Nova aba adicionada!");
            abasAbertas++;
        } else if(!iPhoneLigado) {
            System.out.println(IPHONE_DESLIGADO);
        } else {
            System.out.println(NAVEGADOR_FECHADO);
        }
    }

    @Override
    public void atualizarPagina() {
        if(iPhoneLigado && verificarApp("Navegador")) {
            System.out.println("Atualizando página!");
        } else if (!iPhoneLigado) {
            System.out.println(IPHONE_DESLIGADO);
        } else {
            System.out.println(NAVEGADOR_FECHADO);
        }
    }


    @Override
    public void ligar() {
        if(iPhoneLigado && verificarApp("Contatos")) {
            System.out.println("Realizando ligação!");
        } else if (!iPhoneLigado) {
            System.out.println(IPHONE_DESLIGADO);
        } else {
            System.out.println(CONTATOS_FECHADO);
        }
    }

    @Override
    public void atender() {
        if(iPhoneLigado) {
            System.out.println("Atendendo ligação!");
        } else {
            System.out.println(IPHONE_DESLIGADO);
        }
    }

    @Override
    public void iniciarCorreioDeVoz() {
        if (iPhoneLigado && verificarApp("Contatos")) {
            System.out.println("Iniciando Correio de Voz!");
        } else if (!iPhoneLigado) {
            System.out.println(IPHONE_DESLIGADO);
        } else {
            System.out.println(CONTATOS_FECHADO);
        }
    }

    public String getMusicaSelecionada() {
        return musicaSelecionada;
    }

}
