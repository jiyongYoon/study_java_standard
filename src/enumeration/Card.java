package enumeration;

public class Card {

    public Card(Kind kind, Value value) {
        this.kind = kind;
        this.value = value;
    }

    /**
     * 모든 열거형 클래스는 java.lang.Enum의 자손이다.
     */
    enum Kind {
        CLOVER(CardColor.BLACK),
        HEART(CardColor.RED),
        DIAMOND(CardColor.RED),
        SPADE(CardColor.BLACK);
        final CardColor color; // 열거형에 맴버 추가가 가능하며, Enum 멤버 추가도 가능하다.

        Kind(CardColor color) {
            this.color = color;
        }

        public CardColor getColor() {
            return color;
        }
    }
    enum CardColor {
        RED,
        BLACK
    }
    enum Value {
        TOW,
        THREE,
        FOUR
    }

    final Kind kind;
    final Value value;

    public static void main(String[] args) {
        System.out.println(Kind.CLOVER.getDeclaringClass()); // class enumeration.Card$Kind
        System.out.println(Kind.HEART.name()); // HEART
        System.out.println(Kind.DIAMOND.ordinal()); // 2
        System.out.println(Kind.valueOf("SPADE")); // SPADE
        System.out.println(Kind.CLOVER.getColor()); // BLACK

    }
}
