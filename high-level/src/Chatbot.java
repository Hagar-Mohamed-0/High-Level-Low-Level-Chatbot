import java.util.*;
public class Chatbot {

    static ArrayList<String> userIDs = new ArrayList<>();
    static ArrayList<String> userNames = new ArrayList<>();
    static ArrayList<String> userAges = new ArrayList<>();
    static ArrayList<String> schoolOrColleges = new ArrayList<>();
    static ArrayList<String> majors = new ArrayList<>();
    static ArrayList<String> favoriteColors = new ArrayList<>();
    static ArrayList<ArrayList<String>> interestLists = new ArrayList<>();
    static ArrayList<ArrayList<String>> historyLists = new ArrayList<>();



    static Map<List<String>, String> entityAnswers = new HashMap<>();
    static {
        entityAnswers.put(Arrays.asList("pyramids", "egypt pyramids"), "The pyramids are over 4,500 years old.");
        entityAnswers.put(Arrays.asList("burj khalifa", "khalifa tower"), "Burj Khalifa is 828 meters tall.");
        entityAnswers.put(Arrays.asList("earth", "our planet"), "Earth is about 4.5 billion years old.");
        entityAnswers.put(Arrays.asList("sun", "sol"), "The Sun is approximately 4.6 billion years old.");
        entityAnswers.put(Arrays.asList("moon", "luna"), "The Moon is about 4.5 billion years old.");
        entityAnswers.put(Arrays.asList("einstein", "albert einstein"), "Albert Einstein was born in 1879 and died in 1955.");
        entityAnswers.put(Arrays.asList("java"), "Java was released in 1995.");
        entityAnswers.put(Arrays.asList("google","gog"), "Google was founded in 1998.");
        entityAnswers.put(Arrays.asList("messi", "lionel messi"), "Lionel Messi was born in 1987, so he is about 37 years old.");
        entityAnswers.put(Arrays.asList("facebook", "meta"), "Facebook was launched in 2004 and is now called Meta.");
        entityAnswers.put(Arrays.asList("windows", "windows os"), "Windows was first released in 1985.");
        entityAnswers.put(Arrays.asList("tesla"), "Tesla was founded in 2003.");
        entityAnswers.put(Arrays.asList("newton", "isaac newton"), "Isaac Newton was born in 1643 and defined gravity.");

        //electronics questions
        entityAnswers.put(Arrays.asList("ac", "alternating current"), "AC (Alternating Current) is an electric current that periodically reverses direction.");
        entityAnswers.put(Arrays.asList("dc", "direct current"), "DC (Direct Current) flows in one direction only, typically from batteries.");
        entityAnswers.put(Arrays.asList("led", "light emitting diode"), "An LED is a diode that emits light when current flows through it.");
        entityAnswers.put(Arrays.asList("ic", "integrated circuit"), "An IC (Integrated Circuit) is a set of electronic circuits on a small chip.");
        entityAnswers.put(Arrays.asList("555 timer", "timer ic"), "The 555 Timer IC is widely used for creating timers and oscillators.");
        entityAnswers.put(Arrays.asList("logic gates", "digital gates"), "Logic gates perform basic logical functions like AND, OR, and NOT.");
        entityAnswers.put(Arrays.asList("and gate"), "An AND gate outputs HIGH only if all inputs are HIGH.");
        entityAnswers.put(Arrays.asList("or gate"), "An OR gate outputs HIGH if at least one input is HIGH.");
        entityAnswers.put(Arrays.asList("not gate", "inverter"), "A NOT gate inverts the input signal. HIGH becomes LOW, and vice versa.");
        entityAnswers.put(Arrays.asList("nand gate"), "A NAND gate outputs LOW only if all inputs are HIGH.");
        entityAnswers.put(Arrays.asList("nor gate"), "A NOR gate outputs HIGH only if all inputs are LOW.");
        entityAnswers.put(Arrays.asList("xor gate"), "An XOR gate outputs HIGH only when inputs are different.");
        entityAnswers.put(Arrays.asList("voltmeter"), "A voltmeter measures the voltage across two points in a circuit.");
        entityAnswers.put(Arrays.asList("ammeter"), "An ammeter measures the current flowing through a circuit.");
        entityAnswers.put(Arrays.asList("ohmmeter"), "An ohmmeter measures electrical resistance.");
        entityAnswers.put(Arrays.asList("potentiometer", "variable resistor"), "A potentiometer is a variable resistor often used to adjust levels, like volume.");
        entityAnswers.put(Arrays.asList("eeprom", "flash memory"), "EEPROM is a type of non-volatile memory used to store data permanently.");
        entityAnswers.put(Arrays.asList("pcb", "printed circuit board"), "A PCB mechanically supports and electrically connects electronic components.");
        entityAnswers.put(Arrays.asList("frequency", "hertz"), "Frequency is the number of cycles per second, measured in hertz (Hz).");
        entityAnswers.put(Arrays.asList("signal", "electrical signal"), "A signal in electronics carries information, often through voltage or current changes.");
        entityAnswers.put(Arrays.asList("resistor", "resistance"), "A resistor is an electronic component that limits current flow.");
        entityAnswers.put(Arrays.asList("capacitor", "capacitance"), "A capacitor stores electrical energy in an electric field.");
        entityAnswers.put(Arrays.asList("inductor", "inductance"), "An inductor stores energy in a magnetic field when current flows through it.");
        entityAnswers.put(Arrays.asList("diode", "pn junction"), "A diode allows current to flow in one direction only.");
        entityAnswers.put(Arrays.asList("transistor", "bjt", "mosfet"), "A transistor is a semiconductor device used to amplify or switch electronic signals.");
        entityAnswers.put(Arrays.asList("ohm's law", "ohm law"), "Ohm's Law states that V = I × R, where V is voltage, I is current, and R is resistance.");
        entityAnswers.put(Arrays.asList("arduino"), "Arduino is an open-source electronics platform based on easy-to-use hardware and software.");
        entityAnswers.put(Arrays.asList("raspberry pi", "pi"), "Raspberry Pi is a small, affordable computer used for programming and electronics projects.");
        entityAnswers.put(Arrays.asList("voltage", "electric potential"), "Voltage is the difference in electric potential between two points.");
        entityAnswers.put(Arrays.asList("current", "electric current"), "Electric current is the flow of electric charge through a conductor.");
        entityAnswers.put(Arrays.asList("power supply", "dc power supply"), "A power supply provides the necessary voltage and current to electronic circuits.");
        entityAnswers.put(Arrays.asList("multimeter", "dmm"), "A multimeter is a tool used to measure voltage, current, and resistance.");
        entityAnswers.put(Arrays.asList("oscilloscope", "scope"), "An oscilloscope displays electrical signals graphically, usually as voltage over time.");
        entityAnswers.put(Arrays.asList("breadboard"), "A breadboard is used to build and test electronic circuits without soldering.");
        entityAnswers.put(Arrays.asList("microcontroller", "mcu"), "A microcontroller is a compact integrated circuit designed to govern a specific operation in an embedded system.");
        
        // chat kerywords
        entityAnswers.put(Arrays.asList("hi", "hello"), "Hi there!");
        entityAnswers.put(Arrays.asList("bye", "goodbye"), "Goodbye! See you later.");
        entityAnswers.put(Arrays.asList("joke", "funny"), "Why don’t skeletons fight? They don’t have the guts!");
        entityAnswers.put(Arrays.asList("how are you", "how r u"), "I'm just a bot, but I'm doing well!");
        entityAnswers.put(Arrays.asList("your name", "who are you"), "I'm KeyBot, your friendly chatbot.");
        entityAnswers.put(Arrays.asList("my name is"), "Nice to meet you!");
        entityAnswers.put(Arrays.asList("i am", "years old"), "Got it. I'll remember that.");
        entityAnswers.put(Arrays.asList("what is my name"), "You told me your name before!");
        entityAnswers.put(Arrays.asList("how old am i"), "You mentioned your age earlier!");
        entityAnswers.put(Arrays.asList("time"), "Sorry, I don't have a watch!");
        entityAnswers.put(Arrays.asList("date"), "It's a beautiful day!");
        entityAnswers.put(Arrays.asList("thanks"), "You're welcome!");
        entityAnswers.put(Arrays.asList("good"), "That's great to hear!");
        entityAnswers.put(Arrays.asList("sad"), "I'm here if you need someone to talk to.");
        entityAnswers.put(Arrays.asList("angry"), "Take a deep breath. It'll be fine.");
        entityAnswers.put(Arrays.asList("hungry"), "Maybe grab a snack!");
        entityAnswers.put(Arrays.asList("bored"), "Wanna play or chat more?");
        entityAnswers.put(Arrays.asList("love"), "Aww, I like you too!");
        entityAnswers.put(Arrays.asList("hate"), "Let's spread love not hate.");
        entityAnswers.put(Arrays.asList("school"), "School's tough, hang in there!");
        entityAnswers.put(Arrays.asList("game"), "Games are fun! Tell me more.");
        entityAnswers.put(Arrays.asList("music"), "Music makes life better!");

        //football
        entityAnswers.put(Arrays.asList("ronaldo", "cristiano ronaldo"), "Cristiano Ronaldo was born in 1985 and has won five Ballon d'Or awards.");
        entityAnswers.put(Arrays.asList("neymar", "neymar jr"), "Neymar is a Brazilian footballer known for his skill and flair, born in 1992.");
        entityAnswers.put(Arrays.asList("world cup", "fifa world cup"), "The FIFA World Cup is held every four years and first started in 1930.");
        entityAnswers.put(Arrays.asList("premier league", "english premier league"), "The Premier League is the top level of the English football league system.");
        entityAnswers.put(Arrays.asList("barcelona", "fc barcelona"), "FC Barcelona is a Spanish football club founded in 1899.");
        entityAnswers.put(Arrays.asList("zidane", "zinedine zidane"), "Zinedine Zidane is a French football legend and former Real Madrid coach.");
        entityAnswers.put(Arrays.asList("messi vs ronaldo"), "The Messi vs Ronaldo debate has been one of football's biggest rivalries.");
        entityAnswers.put(Arrays.asList("champions league", "ucl"), "The UEFA Champions League is the top club competition in European football.");
        entityAnswers.put(Arrays.asList("brazil", "brazil national team"), "Brazil has won the FIFA World Cup 5 times — more than any other country.");
        entityAnswers.put(Arrays.asList("mohamed salah", "salah"), "Mohamed Salah is an Egyptian forward who plays for Liverpool FC.");
        entityAnswers.put(Arrays.asList("haaland", "erling haaland"), "Erling Haaland is a Norwegian striker known for his incredible goal-scoring record.");
        entityAnswers.put(Arrays.asList("ballon d'or", "ballon dor"), "The Ballon d'Or is awarded yearly to the best football player in the world.");
        entityAnswers.put(Arrays.asList("real madrid", "rmfc"), "Real Madrid is the most successful club in Champions League history.");
        entityAnswers.put(Arrays.asList("kylian mbappe", "mbappe"), "Kylian Mbappé is a French footballer known for his speed and goal-scoring ability.");
        entityAnswers.put(Arrays.asList("ronaldinho"), "Ronaldinho was known for his creativity and flair, winning the Ballon d'Or in 2005.");
        entityAnswers.put(Arrays.asList("maradona", "diego maradona"), "Diego Maradona was an Argentine legend famous for the 'Hand of God' goal.");
        entityAnswers.put(Arrays.asList("pele"), "Pelé won 3 World Cups with Brazil and is regarded as one of the greatest footballers of all time.");
        entityAnswers.put(Arrays.asList("arsenal"), "Arsenal FC is a Premier League club known for going unbeaten in the 2003–04 season.");
        entityAnswers.put(Arrays.asList("liverpool"), "Liverpool FC is a historic English club with 6 Champions League titles.");
        entityAnswers.put(Arrays.asList("manchester united", "man united"), "Manchester United is one of the most successful clubs in English football history.");
        entityAnswers.put(Arrays.asList("goalkeeper", "goalie"), "The goalkeeper is the only player allowed to use hands in the penalty box.");
        //music
        entityAnswers.put(Arrays.asList("beatles", "the beatles"), "The Beatles were an English rock band formed in Liverpool in 1960.");
        entityAnswers.put(Arrays.asList("michael jackson", "king of pop"), "Michael Jackson was known as the King of Pop and was born in 1958.");
        entityAnswers.put(Arrays.asList("taylor swift", "swift"), "Taylor Swift is an American singer-songwriter known for narrative songs about her personal life.");
        entityAnswers.put(Arrays.asList("rock music", "rock"), "Rock music originated in the 1950s and became very popular in the 1960s and 70s.");
        entityAnswers.put(Arrays.asList("grammy", "grammy awards"), "The Grammy Awards are presented by the Recording Academy to recognize musical achievements.");
        entityAnswers.put(Arrays.asList("drake"), "Drake is a Canadian rapper, singer, and songwriter known for blending rap and R&B.");
        entityAnswers.put(Arrays.asList("bts", "bangtan boys"), "BTS is a South Korean boy band that has gained global popularity.");
        entityAnswers.put(Arrays.asList("ed sheeran"), "Ed Sheeran is a British singer-songwriter known for hits like 'Shape of You' and 'Perfect'.");
        entityAnswers.put(Arrays.asList("beyonce"), "Beyoncé is an American singer and performer who was once part of Destiny's Child.");
        entityAnswers.put(Arrays.asList("elvis", "elvis presley"), "Elvis Presley is known as the 'King of Rock and Roll'.");
        entityAnswers.put(Arrays.asList("rihanna"), "Rihanna is a Barbadian singer and entrepreneur known for her fashion and music career.");
        entityAnswers.put(Arrays.asList("grammy record", "most grammys"), "Georg Solti holds the record for most Grammy wins, with 31.");
        entityAnswers.put(Arrays.asList("billie eilish"), "Billie Eilish gained fame with her unique sound and won several Grammys at age 18.");
        //gaming
        entityAnswers.put(Arrays.asList("fortnite"), "Fortnite is a popular battle royale game developed by Epic Games.");
        entityAnswers.put(Arrays.asList("minecraft"), "Minecraft is a sandbox game released in 2011 that allows players to build and explore blocky worlds.");
        entityAnswers.put(Arrays.asList("esports"), "Esports refers to competitive video gaming, often with large prize pools.");
        entityAnswers.put(Arrays.asList("league of legends", "lol"), "League of Legends is a team-based strategy game and one of the biggest esports titles.");
        entityAnswers.put(Arrays.asList("pubg"), "PUBG is a multiplayer battle royale game that helped popularize the genre.");
        entityAnswers.put(Arrays.asList("playstation", "ps"), "PlayStation is a gaming console developed by Sony, first released in 1994.");
        entityAnswers.put(Arrays.asList("nintendo"), "Nintendo is a Japanese gaming company known for games like Mario, Zelda, and Pokémon.");
        entityAnswers.put(Arrays.asList("mount everest", "everest"), "Mount Everest is the highest mountain on Earth, standing at 8,848 meters.");
        entityAnswers.put(Arrays.asList("world war 2", "ww2"), "World War II lasted from 1939 to 1945 and involved most of the world’s nations.");
        entityAnswers.put(Arrays.asList("egypt"), "Egypt is home to one of the world’s oldest civilizations and the Great Pyramids.");
        entityAnswers.put(Arrays.asList("rome", "roman empire"), "The Roman Empire was one of the most powerful civilizations in ancient history.");
        entityAnswers.put(Arrays.asList("amazon river"), "The Amazon River is the second longest river in the world and flows through South America.");
        entityAnswers.put(Arrays.asList("sahara", "sahara desert"), "The Sahara is the largest hot desert in the world, located in North Africa.");
        entityAnswers.put(Arrays.asList("great wall of china"), "The Great Wall of China stretches over 13,000 miles and was built for defense.");
        //characters
        entityAnswers.put(Arrays.asList("einstein", "albert einstein"),"Albert Einstein (1879-1955) was a theoretical physicist best known for developing the theory of relativity.");
        entityAnswers.put(Arrays.asList("newton", "isaac newton"), "Isaac Newton (1643-1727) was an English mathematician and physicist who formulated the laws of motion and universal gravitation.");
        entityAnswers.put(Arrays.asList("curie", "marie curie"),"Marie Curie (1867-1934) was a pioneering physicist and chemist known for her work on radioactivity and discovering radium.");
        entityAnswers.put(Arrays.asList("darwin", "charles darwin"), "Charles Darwin (1809-1882) was an English naturalist best known for his theory of evolution through natural selection.");
        entityAnswers.put(Arrays.asList("galileo", "galileo galilei"), "Galileo Galilei (1564-1642) was an Italian astronomer, physicist, and engineer, who played a major role in the scientific revolution.");
        entityAnswers.put(Arrays.asList("shakespeare", "william shakespeare"), "William Shakespeare (1564-1616) was an English playwright, poet, and actor, famous for 'Hamlet' and 'Romeo and Juliet'.");
        entityAnswers.put(Arrays.asList("dickens", "charles dickens"),"Charles Dickens (1812-1870) was an English writer and social critic, famous for novels like 'A Tale of Two Cities' and 'Oliver Twist'.");
        entityAnswers.put(Arrays.asList("austen", "jane austen"),"Jane Austen (1775-1817) was an English novelist, known for works like 'Pride and Prejudice' and 'Sense and Sensibility'.");
        entityAnswers.put(Arrays.asList("twain", "mark twain"), "Mark Twain (1835-1910) was an American author, best known for 'The Adventures of Tom Sawyer' and 'Adventures of Huckleberry Finn'.");
        entityAnswers.put(Arrays.asList("hemingway", "ernest hemingway"), "Ernest Hemingway (1899-1961) was an American novelist and short story writer, known for 'The Old Man and the Sea' and 'A Farewell to Arms'.");
        entityAnswers.put(Arrays.asList("picasso", "pablo picasso"), "Pablo Picasso (1881-1973) was a Spanish painter and sculptor, co-founder of the Cubist movement.");
        entityAnswers.put(Arrays.asList("da vinci", "leonardo da vinci"), "Leonardo da Vinci (1452-1519) was an Italian polymath, known for masterpieces like 'Mona Lisa' and 'The Last Supper'.");
        entityAnswers.put(Arrays.asList("van gogh", "vincent van gogh"), "Vincent van Gogh (1853-1890) was a Dutch post-impressionist painter, famous for works like 'Starry Night' and 'Sunflowers'.");
        entityAnswers.put(Arrays.asList("monet", "claude monet"), "Claude Monet (1840-1926) was a French impressionist painter, best known for his series of 'Water Lilies'.");
        entityAnswers.put(Arrays.asList("rembrandt", "rembrandt van rijn"), "Rembrandt van Rijn (1606-1669) was a Dutch Baroque painter and printmaker, known for 'The Night Watch' and 'Self-Portraits'.");
        entityAnswers.put(Arrays.asList("marlon brando", "brando"), "Marlon Brando (1924-2004) was an American actor, known for 'The Godfather' and 'A Streetcar Named Desire'.");
        entityAnswers.put(Arrays.asList("audrey hepburn", "hepburn"), "Audrey Hepburn (1929-1993) was a British actress and humanitarian, known for 'Breakfast at Tiffany's' and 'Roman Holiday'.");
        entityAnswers.put(Arrays.asList("robert de niro", "de niro"), "Robert De Niro (1943-) is an American actor, known for 'Taxi Driver', 'Raging Bull', and 'The Godfather'.");
        entityAnswers.put(Arrays.asList("meryl streep", "streep"), "Meryl Streep (1949-) is an American actress, renowned for her roles in 'The Devil Wears Prada' and 'Sophie's Choice'.");
        entityAnswers.put(Arrays.asList("jack nicholson", "nicholson"), "Jack Nicholson (1937-) is an American actor, known for 'The Shining' and 'One Flew Over the Cuckoo's Nest'.");


    }


    static List<String> verbToBeList = Arrays.asList("is", "are", "am", "was", "were", "has", "have");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter user ID (or type 'exit' to quit): ");
            String inputID = scanner.nextLine();
            if (inputID.equalsIgnoreCase("exit")) break;

            int userIndex = getOrCreateUser(inputID);
            System.out.println("Start chatting! Type 'history' to view chat, 'search <word>' to find something, or 'bye' to exit.");

            while (true) {
                System.out.print("\nYou: ");
                String input = scanner.nextLine().toLowerCase().trim();

                if (input.equals("bye")) {
                    System.out.println("Bot: Goodbye!");
                    break;
                }

                if (input.equals("history")) {
                    System.out.println("\n--- Chat History ---");
                    for (String line : historyLists.get(userIndex)) {
                        System.out.println(line);
                    }
                    continue;
                }

                if (input.startsWith("search ")) {
                    String keyword = input.substring(7).trim();
                    System.out.println("\nSearching for '" + keyword + "' in your chat:");
                    boolean found = false;
                    for (String msg : historyLists.get(userIndex)) {
                        if (msg.toLowerCase().contains(keyword)) {
                            System.out.println(msg);
                            found = true;
                        }
                    }
                    if (!found) System.out.println("No messages found containing '" + keyword + "'.");
                    continue;
                }

                String response = generateResponse(input, userIndex);
                System.out.println("Bot: " + response);
                historyLists.get(userIndex).add("You: " + input);
                historyLists.get(userIndex).add("Bot: " + response);
            }
        }
        scanner.close();
        System.out.println("Chatbot session ended.");
    }


    static int getOrCreateUser(String id) {
        for (int i = 0; i < userIDs.size(); i++) {
            if (userIDs.get(i).equals(id)) return i;
        }
        userIDs.add(id);
        userNames.add("");
        userAges.add("");
        schoolOrColleges.add("");
        majors.add("");
        favoriteColors.add("");
        interestLists.add(new ArrayList<>());
        historyLists.add(new ArrayList<>());
        return userIDs.size() - 1;
    }




    static String generateResponse(String input, int index) {
        if (input.startsWith("i love ")) {
            String interest = input.replace("i love", "").trim();
            if (!interest.isEmpty()) {
                interestLists.get(index).add(interest);
                return "Nice! I'll remember that you love " + interest + ".";
            }
        }
    
        if (input.startsWith("i study ")) {
            String major = input.replace("i study", "").trim();
            if (!major.isEmpty()) {
                majors.set(index, major);
                return "Cool! You're studying " + major + ". I'll remember that.";
            }
        }
    
        if (input.contains("what do i love")) {
            List<String> loves = interestLists.get(index);
            if (loves.isEmpty()) return "You haven't told me what you love yet!";
            return "You love: " + String.join(", ", loves);
        }
    
        if (input.contains("what's my major") || input.contains("what is my major")) {
            String major = majors.get(index);
            return major.isEmpty() ? "I don't know your major yet." : "You're studying " + major + ".";
        }
    
        if (input.contains("my name is")) {
            String name = input.replace("my name is", "").trim();
            userNames.set(index, name);
            return "Nice to meet you, " + capitalize(name) + "!";
        }
    
        if ((input.contains("i am") || input.contains("i'm")) && input.contains("years old")) {
            String age = input.replaceAll("[^0-9]", "");
            userAges.set(index, age);
            return "Got it. You're " + age + " years old!";
        }
    
        if (input.contains("what is my name")) {
            String name = userNames.get(index);
            return name.isEmpty() ? "I don't know your name yet." : "Your name is " + capitalize(name) + ".";
        }
    
        if (input.contains("how old am i")) {
            String age = userAges.get(index);
            return age.isEmpty() ? "I don't know your age yet." : "You're " + age + " years old.";
        }
    
        if (input.contains("my favorite color is")) {
            String color = input.replace("my favorite color is", "").trim();
            favoriteColors.set(index, color);
            return "Noted! " + capitalize(color) + " is a great color.";
        }
    
        if (input.contains("what is my favorite color")) {
            String color = favoriteColors.get(index);
            return color.isEmpty() ? "I don't know your favorite color yet." : "You told me your favorite color is " + color + ".";
        }
    
        for (Map.Entry<List<String>, String> entry : entityAnswers.entrySet()) {
            for (String alias : entry.getKey()) {
                if (input.contains(alias)) return entry.getValue();
            }
        }
    
        String mathInput = input.replaceAll("[^0-9+\\-*/.]", "");
        if (mathInput.matches("\\d+[+\\-*/]\\d+")) {
            char operator = ' ';
            for (char ch : mathInput.toCharArray()) {
                if ("+-*/".indexOf(ch) != -1) {
                    operator = ch;
                    break;
                }
            }
    
            if (operator != ' ') {
                String[] parts = mathInput.split("\\" + operator);
                if (parts.length == 2 && parts[0].matches("\\d+") && parts[1].matches("\\d+")) {
                    double a = Double.parseDouble(parts[0]);
                    double b = Double.parseDouble(parts[1]);
    
                    if (operator == '/' && b == 0) return "Division by zero is not allowed.";
    
                    double result = 0;
                    switch (operator) {
                        case '+': result = a + b; break;
                        case '-': result = a - b; break;
                        case '*': result = a * b; break;
                        case '/': result = a / b; break;
                    }
                    return "The answer is: " + result;
                } else {
                    return "I need valid numbers to do the math.";
                }
            }
        }

        if (startsWithVerbToBe(input)) {
            String[] replies = {"Yes.", "No.", "Maybe.", "Absolutely.", "Never."};
            return replies[new Random().nextInt(replies.length)];
        }
    
        
    
        return "Sorry, I didn't understand that.";
    }
  
    static boolean startsWithVerbToBe(String input) {
        return verbToBeList.stream().anyMatch(verb -> input.startsWith(verb + " "));
    }

    static String capitalize(String text) {
        if (text.isEmpty()) return text;
        return Character.toUpperCase(text.charAt(0)) + text.substring(1);
    }
}
