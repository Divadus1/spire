package th;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.GainGoldTextEffect;

import basemod.abstracts.CustomCard;
import basemod.helpers.BaseModCardTags;

import static th.TreasurePatch.TREASURE;

public class CopperCoins extends CustomCard {
    public static final String ID = "TH:CopperCoins";
    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    // Get object containing the strings that are displayed in the game.
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/treasure.png";
    private static final int COST = 2;

    public CopperCoins() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION,
                TreasurePatch.TREASURE, AbstractCard.CardColor.COLORLESS,
                AbstractCard.CardRarity.RARE, AbstractCard.CardTarget.NONE);
        this.exhaust = true;
        this.baseMagicNumber = this.magicNumber = 1;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        p.gainGold(this.magicNumber);
        AbstractDungeon.effectList.add(new GainGoldTextEffect(this.magicNumber));
    }

    @Override
    public void upgrade() {
    }

}
