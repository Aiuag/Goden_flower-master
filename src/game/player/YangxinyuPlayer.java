package game.player;

import game.Manager;
import game.Player;
import game.Poker;

import java.util.Collections;
import java.util.List;

public class YangxinyuPlayer implements Player {
    @Override
    public String getName() {
        return "杨赌神";
    }

    @Override
    public String getStuNum() {
        return "2019211855";
    }

    @Override
    public void onGameStart(Manager manager, int totalPlayer) {

    }

    @Override
    public int bet(int time, int round, int lastPerson, int moneyOnDesk, int moneyYouNeedToPayLeast, List<Poker> pokers) {
        if (isSamePoint(pokers) || isSameColorStraight(pokers) || isSameColor(pokers) || isStraight(pokers) )
            return moneyYouNeedToPayLeast*3-1;
        else
            return 0;
    }

    @Override
    public void onResult(int time, boolean isWin, List<Poker> pokers) {

    }
    //是否同花
    private boolean isSameColor(List<Poker> pokers) {
        return pokers.get(0).getSuit() == pokers.get(1).getSuit() &&
                pokers.get(1).getSuit() == pokers.get(2).getSuit();
    }
    //是否顺子
    private boolean isStraight(List<Poker> pokers) {
        Collections.sort(pokers);
        return Math.abs(pokers.get(0).getPoint().getNum() - pokers.get(1).getPoint().getNum()) == 1
                && Math.abs(pokers.get(1).getPoint().getNum() - pokers.get(2).getPoint().getNum()) == 1;

    }
    //是否顺金
    private boolean isSameColorStraight(List<Poker> handCards) {
        return isSameColor(handCards) && isStraight(handCards);
    }
    //是否对子
    private boolean isPair(List<Poker> pokers) {
        return pokers.get(0).getPoint().getNum() == pokers.get(1).getPoint().getNum()
                || pokers.get(1).getPoint().getNum() == pokers.get(2).getPoint().getNum()
                || pokers.get(0).getPoint().getNum() == pokers.get(2).getPoint().getNum();
    }
    //是否筒子
    private boolean isSamePoint(List<Poker> handCards) {
        return handCards.get(0).getPoint() == handCards.get(1).getPoint()
                && handCards.get(2).getPoint() == handCards.get(1).getPoint();

    }
}
