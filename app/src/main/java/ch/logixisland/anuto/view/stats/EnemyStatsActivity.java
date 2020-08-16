package ch.logixisland.anuto.view.stats;

import android.content.Context;
import android.os.Bundle;
import android.widget.GridView;

import ch.logixisland.anuto.AnutoApplication;
import ch.logixisland.anuto.R;
import ch.logixisland.anuto.engine.logic.entity.EntityRegistry;
import ch.logixisland.anuto.engine.theme.ActivityType;
import ch.logixisland.anuto.engine.theme.Theme;
import ch.logixisland.anuto.engine.theme.ThemeManager;
import ch.logixisland.anuto.view.AnutoActivity;

public class EnemyStatsActivity extends AnutoActivity implements ThemeManager.Listener {

    private Context mAppContext;
    private Theme mTheme;
    private EntityRegistry mEntityRegistry;

    public EnemyStatsActivity() {
        AnutoApplication app = AnutoApplication.getInstance();
        mAppContext = app.getApplicationContext();
        mTheme = app.getGameFactory().getGameEngine().getThemeManager().getTheme();
        mEntityRegistry = app.getGameFactory().getEntityRegistry();
    }

    @Override
    protected ActivityType getActivityType() {
        return ActivityType.Normal;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enemy_stats);

        EnemiesAdapter adapter = new EnemiesAdapter(this, mTheme, mEntityRegistry);

        GridView grid_enemies = findViewById(R.id.grid_enemies);
        grid_enemies.setAdapter(adapter);
    }
}
