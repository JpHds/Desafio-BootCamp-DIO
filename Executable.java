public class Executable {
    public static void main(String[] args) {
        Navigator navigator = new Navigator();
        Contacts contacts = new Contacts();
        Player player = new Player();
        Iphone iphone = new Iphone();
        Teste testeDeERRO = new Teste();
        iphone.open(player);
        player.play();
        player.pause();
        // iphone.open(testeDeERRO);
    }
}
