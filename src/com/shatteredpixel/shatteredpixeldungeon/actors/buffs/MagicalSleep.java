/*
 * Pixel Dungeon
 * Copyright (C) 2012-2014  Oleg Dolya
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package com.shatteredpixel.shatteredpixeldungeon.actors.buffs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.ui.BuffIndicator;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;

public class MagicalSleep extends Buff {

    private static final float STEP = 1f;
    public static final float SWS	= 1.5f;

    @Override
    public boolean attachTo( Char target ) {
        if (super.attachTo( target )) {

            target.paralysed = true;

            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean act(){
        if (target instanceof Hero) {
            target.HP = Math.min(target.HP+1, target.HT);
            if (target.HP == target.HT) {
                GLog.p("You wake up feeling refreshed and healthy.");
                detach();
            }
        }
        spend( STEP );
        return true;
    }

    @Override
    public void detach() {
        target.paralysed = false;
        super.detach();
    }

    @Override
    public int icon() {
        return BuffIndicator.MAGIC_SLEEP;
    }

    @Override
    public String toString() {
        return "Magical Sleep";
    }
}