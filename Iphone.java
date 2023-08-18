public class Iphone implements Contatos, Navegador, ReprodutorMusical {

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
    public void abrirReprodutor() {
        if(iPhoneLigado && !reprodutorAberto) {
            reprodutorAberto = true;
            System.out.println("Reprodutor aberto!");
        } else if(!iPhoneLigado) {
            System.out.println(IPHONE_DESLIGADO);
        } else {
            System.out.println("O reprodutor já está aberto!");
        }
    }

    @Override
    public void fecharReprodutor() {
        if (iPhoneLigado && reprodutorAberto) {
            reprodutorAberto = false;
            System.out.println(REPRODUTOR_FECHADO);
        } else if (!iPhoneLigado) {
            System.out.println(IPHONE_DESLIGADO);
        } else {
            System.out.println("O reprodutor já está fechado!");
        }
    }

    @Override
    public void tocar() {
        if (musicaSelecionada!=null && iPhoneLigado && reprodutorAberto && !tocando) {
            tocando = true;
            System.out.println("Tocando " + getMusicaSelecionada() + "!");
        } else if (!iPhoneLigado){
            System.out.println(IPHONE_DESLIGADO);
        }else if(!reprodutorAberto){
            System.out.println(REPRODUTOR_FECHADO);
        } else if (musicaSelecionada == null){
            System.out.println("Nenhuma música selecionada para tocar!");
        } else {
            System.out.println("O reprodutor já está tocando!");
        }
    }

    @Override
    public void pausar() {
        if (iPhoneLigado && reprodutorAberto && tocando) {
            tocando = false;
            System.out.println("Reprodutor pausado!");
        } else if(!iPhoneLigado) {
            System.out.println(IPHONE_DESLIGADO);
        } else if(!reprodutorAberto){
            System.out.println(REPRODUTOR_FECHADO);
        } else {
            System.out.println("O reprodutor não está tocando!");
        }
    }

    @Override
    public void selecionarMusica(String musica) {
        if (iPhoneLigado && reprodutorAberto) {
            System.out.println("Música selecionada: " + musica);
            musicaSelecionada = musica;
        } else if (!iPhoneLigado){
            System.out.println(IPHONE_DESLIGADO);
        } else {
            System.out.println("Impossível tocar a música. O reprodutor está fechado!");
        }
    }

    @Override
    public void abrirNavegador() {
        if (iPhoneLigado && !navegadorAberto) {
            navegadorAberto = true;
            System.out.println("Navegador aberto!");
        } else if (!iPhoneLigado) {
            System.out.println(IPHONE_DESLIGADO);
        } else {
            System.out.println("O navegador já está aberto!");
        }
    }

    @Override
    public void fecharNavegador() {
        if(iPhoneLigado && navegadorAberto) {
            navegadorAberto = false;
            System.out.println(NAVEGADOR_FECHADO);
        } else if (!iPhoneLigado) {
            System.out.println(IPHONE_DESLIGADO);
        } else {
            System.out.println("O navegador já está fechado!");
        }
    }

    @Override
    public void exibirPagina(int pag) {
        if(iPhoneLigado && navegadorAberto && pag > 0 && pag <= abasAbertas) {
            System.out.println("Exibindo a página " + pag);
        } else if (!iPhoneLigado) {
            System.out.println(IPHONE_DESLIGADO);
        } else if (!navegadorAberto) {
            System.out.println(NAVEGADOR_FECHADO);
        } else {
            System.out.println("A página mencionada não existe!");
        }
    }

    @Override
    public void adicionarNovaAba() {
        if(iPhoneLigado && navegadorAberto) {
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
        if(iPhoneLigado && navegadorAberto) {
            System.out.println("Atualizando página!");
        } else if (!iPhoneLigado) {
            System.out.println(IPHONE_DESLIGADO);
        } else {
            System.out.println(NAVEGADOR_FECHADO);
        }
    }

    @Override
    public void abrirContatos() {
        if(iPhoneLigado) {
            contatosAberto = true;
        } else {
            System.out.println(IPHONE_DESLIGADO);
        }
    }

    @Override
    public void fecharContatos() {
        if(iPhoneLigado && contatosAberto) {
            contatosAberto = false;
            System.out.println("Fechando Contatos!");
        } else if (!iPhoneLigado) {
            System.out.println(IPHONE_DESLIGADO);
        } else {
            System.out.println("O App Contatos já está fechado!");
        }
    }

    @Override
    public void ligar() {
        if(iPhoneLigado && contatosAberto) {
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
        if (iPhoneLigado && contatosAberto) {
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
