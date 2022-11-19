package bridge;

import static bridge.Checker.*;

import constant.Values.BridgeCase;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private Checker checker = new Checker();
    private List<String> bridge;
    private List<String> moves;
    private List<BridgeCase> results;
    private int index;

    public BridgeGame(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(size);
        moves=new ArrayList<>();
        index=0;

        System.out.println(bridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgeCase move(String move) {
        moves.add(move);
        BridgeCase bridgeCase = checker.checkMoveSuccess(move,bridge.get(index));
        results.add(bridgeCase);
        return bridgeCase;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        moves=new ArrayList<>();
    }

    public Checker getChecker() {
        return checker;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getMoves() {
        return moves;
    }

    public List<BridgeCase> getResults() {
        return results;
    }

    public int getIndex() {
        return index;
    }
}
