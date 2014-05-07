import java.util.HashMap;

/**
 * The responder class represents an interpreter object.
 * It is used to generate an automatic response, based on specified input.
 * Input is presented to the interpreter as a set of words, and based on those
 * words the interpreter will generate a String that represents the response.
 *
 * Internally, the reponder uses a HashMap to associate words with response
 * strings and a list of default responses. If any of the input words is found
 * in the HashMap, the corresponding response is returned. If none of the input
 * words is recognized, one of the default responses is randomly chosen.
 * 
 * @version    1.0
 * @author     Lacy Morrow
 * @see        import java.util.HashMap
 */
public class Interpreter
{
    // Used to map key words to responses.
    private HashMap<String, String> messageMap;

    /**
     * Construct a Responder
     */
    public Interpreter()
    {
        messageMap = new HashMap<String, String>();
        fillMessageMap();
    }

    /**
     * Generate a response from a given set of input words.
     * 
     * @param words  An Array of words entered by the user
     * @return       A string that should be displayed as the response
     */
    public String interpret(String[] words)
    {
        String result = "";
        for(int i=0;i<words.length;i++){
            if(messageMap.containsKey(words[i])){
                result += messageMap.get(words[i]);
            } else {
                result += words[i];
            }
            result += " ";
        }
        return result;
    }

    /**
     * Enter all the known keywords and their associated responses
     * into our message map.
     */
    private void fillMessageMap()
    {
        messageMap.put("2", 
                        "to");
        messageMap.put("moro", 
                        "morrow");
        messageMap.put("nite", 
                        "night");
        messageMap.put("4", 
                        "for");
        messageMap.put("b", 
                        "be");
        messageMap.put("t", 
                        "the");
        messageMap.put("w", 
                        "way");
        messageMap.put("c", 
                        "see");
        messageMap.put("u", 
                        "you");
        messageMap.put("l8r", 
                        "later");
        messageMap.put("d8", 
                        "date");
        messageMap.put("ez", 
                        "easy");
        messageMap.put("fyi", 
                        "for your information");
        messageMap.put("k", 
                        "Okay");
        messageMap.put("l8", 
                        "late");
        messageMap.put("gr8", 
                        "great");
        messageMap.put("msg", 
                        "message");
        messageMap.put("lol", 
                        "laugh out loud");
        messageMap.put("ne", 
                        "any");
        messageMap.put("ne1", 
                        "anyone");
        messageMap.put("no1", 
                        "no one");
        messageMap.put("pls", 
                        "please");
        messageMap.put("prolly", 
                        "probably");
        messageMap.put("r", 
                        "are");
        messageMap.put("sry", 
                        "sorry");
        messageMap.put("spk", 
                        "speak");
        messageMap.put("thnq", 
                        "thank you");
        messageMap.put("tx", 
                        "thanks");
        messageMap.put("thx", 
                        "thanks");
        messageMap.put("w8", 
                        "wait");
        messageMap.put("y", 
                        "why");
        messageMap.put("x", 
                        "ex");
                    }
}
