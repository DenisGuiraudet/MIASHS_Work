public interface Webable {

    String initHtml();       // Un seul appel : pour initialiser la page web
    String toHtml();         // Correspond à un toString() en HTML
    String endHtml();        // Un seul appel : pour terminer la page web

}
