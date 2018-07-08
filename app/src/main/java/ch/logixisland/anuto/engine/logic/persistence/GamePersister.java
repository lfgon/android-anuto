package ch.logixisland.anuto.engine.logic.persistence;

import java.util.ArrayList;
import java.util.List;

import ch.logixisland.anuto.data.KeyValueStore;

public class GamePersister {

    private List<Persister> mPersisterList = new ArrayList<>();

    public void registerPersister(Persister persister) {
        mPersisterList.add(persister);
    }

    public void resetState() {
        for (Persister persister : mPersisterList) {
            persister.resetState();
        }
    }

    public void readState(KeyValueStore gameState) {
        for (Persister persister : mPersisterList) {
            persister.readState(gameState);
        }
    }

    public void writeState(KeyValueStore gameState) {
        for (Persister persister : mPersisterList) {
            persister.writeState(gameState);
        }
    }
}
