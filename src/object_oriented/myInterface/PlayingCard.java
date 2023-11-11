package object_oriented.myInterface;

public interface PlayingCard {

    /**
     * 모두 int a = 1; 과 동일하다. (인터페이스에서 변수는 public, static, final은 생략이 가능하다)
     */
    public static final int SPACE = 4;
    static final int DIAMOND = 3;
    final int HEART = 2;
    static int CLOVER = 1;

    /**
     * 인터페이스에서 메서드는 public abstract가 생략이 가능하다.
     */
    public abstract String getCardNumber();
    String getCardKind();

    /**
     * JDK 1.8부터 인터페이스에서 default 메서드와 static 메서드 사용이 가능해졌다. 구현부를 가질 수 있다.
     */
    default void shuffle() {
        System.out.println("카드를 섞는다.");
    }

    static void newDeck() {
        System.out.println("새로운 카드뭉치를 꺼낸다.");
    }

    public static void main(String[] args) {
        PlayingCard.newDeck();
        PlayingCard playingCard = new PlayingCard() {
            @Override
            public String getCardNumber() {
                return null;
            }

            @Override
            public String getCardKind() {
                return null;
            }
        };

        playingCard.shuffle();
    }
}
