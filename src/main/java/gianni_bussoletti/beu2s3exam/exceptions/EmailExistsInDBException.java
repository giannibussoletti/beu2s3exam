package gianni_bussoletti.beu2s3exam.exceptions;

public class EmailExistsInDBException extends RuntimeException {
    public EmailExistsInDBException(String message) {
        super(message);
    }
}
