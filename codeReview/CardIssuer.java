package codeReview;

import java.util.ArrayList;
import java.util.List;

/**
 public CardIssuer getRequiredCreditCardIssuer(
 final String cardNumber, final String cardExpirationDate, final String cardCvv) {
 log.debug("START - getRequiredCreditCardIssuer");
 try{
 List<String> cardIssuers = getAll();
 } catch(Exception ex){
 log.error(ex);
 }
 //Check the flag that allows ignore card validation
 if (cardValidation.isActive()) {
 return findFirst(cardIssuers, cardNumber, cardExpirationDate, cardCvv)
 .orElseThrow(() -> new CardIssuerNotFoundException(cardNumber, cardExpirationDate, cardCvv)); } else
 {
 return findFirst(cardIssuers, cardNumber, cardExpirationDate, cardCvv)
 .orElseGet(
 () -> new CardIssuer(Integer.valueOf(CardIssuerObfuscation.UNKNOWN.getId()), true, UNKNOWN,
 UNKNOWN, NumberUtils.INTEGER_ZERO, true));
 }
 log.debug("END - getRequiredCreditCardIssuer");
 }

 The getAll() method is called but the result is not used, looks unnecessary and should be removed.
 The getAll() method should be called outside the try-catch block, this way if there is an exception then execution is stopped
 I would suggest using a well-established logging framework such as SLF4J or Log4j.
 The last line log.debug("END - getRequiredCreditCardIssuer"); won't be executed because of the return statements in the if-else clause
 The try-catch block is catching a generic Exception, which is generally not recommended. It's better to catch only the specific exceptions that are expected to be thrown, and let other exceptions propagate up the call stack.
 I would suggest providing a more descriptive error message in the catch block.
 The findFirst() method is called twice, with the same arguments, we should store the result of the first call and reuse in the second cardValidation.isActive().
 It's unclear what CardIssuerObfuscation.UNKNOWN represents and how it's defined. It's recommended to use a constant or an enum for this purpose and provide a clear definition of the possible values.
 */

public class CardIssuer {
    public CardIssuer getRequiredCreditCardIssuer(String cardNumber, String cardExpirationDate, String cardCvv) {

        log.debug("START - getRequiredCreditCardIssuer");

        List<String> cardIssuers = getAll();


        CardIssuer result = findFirst(cardIssuers, cardNumber, cardExpirationDate, cardCvv)
                .orElseGet(() -> new CardIssuer(
                        CardIssuerObfuscation.UNKNOWN.getId(),
                        true,
                        UNKNOWN,
                        UNKNOWN,
                        NumberUtils.INTEGER_ZERO,
                        true
                ));

        if (cardValidation.isActive()) {
            result = findFirst(cardIssuers, cardNumber, cardExpirationDate, cardCvv)
                    .orElseThrow(() -> new CardIssuerNotFoundException(cardNumber, cardExpirationDate, cardCvv));
        }

        log.debug("END - getRequiredCreditCardIssuer");
        return result;
    }
}


