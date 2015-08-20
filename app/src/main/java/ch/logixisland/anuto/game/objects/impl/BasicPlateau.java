package ch.logixisland.anuto.game.objects.impl;

import ch.logixisland.anuto.R;
import ch.logixisland.anuto.game.Layers;
import ch.logixisland.anuto.game.objects.Plateau;
import ch.logixisland.anuto.game.objects.Sprite;

public class BasicPlateau extends Plateau {

    private final Sprite mSprite;

    public BasicPlateau() {
        mSprite = Sprite.fromResources(getGame().getResources(), R.drawable.plateau1, 4);
        mSprite.setListener(this);
        mSprite.setMatrix(1f, 1f, null, null);
        mSprite.setIndex(getGame().getRandom().nextInt(4));
        mSprite.setLayer(Layers.PLATEAU);
    }

    @Override
    public void init() {
        super.init();

        getGame().add(mSprite);
    }

    @Override
    public void clean() {
        super.clean();

        getGame().remove(mSprite);
    }
}
