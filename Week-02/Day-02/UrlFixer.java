
public class UrlFixer {
    public static void main(String[] args) {
        String url = "https//www.reddit.com/r/nevertellmethebots";
        String fixedUrl = url.substring(0,5) + (":") + url.substring(5, url.length());
        fixedUrl = fixedUrl.replace("bots", "odds");

        System.out.println(fixedUrl);
        }
}

