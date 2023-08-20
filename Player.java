import interfaces.IPlayer;

public class Player extends Application implements IPlayer {

    private boolean playing;
    private String music;

    public Player() {
        super.openned = false;
        this.playing = false;
        this.music = null;
    }

    public void play() {
        if(super.openned && !playing) {
            System.out.println("Tocando...");
            playing = true;
        } else if(!super.openned){
            System.out.println("ERRO: O aplicativo Player não está aberto!");
        } else {
            System.out.println("O aplicativo já está tocando!");
        }
    }

    public void pause() {
        if(super.openned && playing) {
            System.out.println("Pausando...");
            playing = false;
        } else if(!super.openned){
            System.out.println("ERRO: O aplicativo Player não está aberto!");
        } else {
            System.out.println("O aplicativo não está tocando!");
        }
    }

    @Override
    public void selectMusic(String mus) {
        music = mus;
    }

    public String getMusic() {
        return music;
    }

    @Override
    public String toString() {
        return "Player";
    }

}