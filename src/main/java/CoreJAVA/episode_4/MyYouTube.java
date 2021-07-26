package CoreJAVA.episode_4;

public class MyYouTube {
    public static void main(String[] args) {

        Youtuber yt = new Youtuber();
        String shared =  yt.shareVideo();
        System.out.println(shared);
        yt.createVideo();



    }

}
