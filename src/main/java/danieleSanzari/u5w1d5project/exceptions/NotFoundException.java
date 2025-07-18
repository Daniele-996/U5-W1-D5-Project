package danieleSanzari.u5w1d5project.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Long id) {
        super("L'elemento con id: " + id + " non è stata trovata!");
    }
}
