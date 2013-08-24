//This tells the game that "tykepol" should be a new pokemon type.
//In the code, it will be referenced as "tykepol.whatever"
pokemon.register_pokemon("tykepol");

//Sets tykepol's images
tykepol.register_image_front(PATH.POKEMON_SPRITES_PATH + "/Tykepol.png");
tykepol.register_image_back(PATH.POKEMON_SPRITES_PATH + "/TykepolB.png");

//Sets tykepol's stats
//??? Unfinished. These stats are tykepol stats
tykepol.set_type_name("Tykepol");
tykepol.set_base_hp(45);
tykepol.set_base_attack(60);
tykepol.set_base_defense(40);
tykepol.set_base_sp_attack(70);
tykepol.set_base_sp_defense(50);
tykepol.set_base_speed(45);

tykepol.set_types("grass420xxxblazer" , "fightabro");

tykepol.register_action("tackle" , "Tackle");
tykepol.register_action("tailwhip" , "Tail Whip");
tykepol.register_action("supertyke" , "Super Tyke long name test test test");

//Hmm... maybe there should be a better way to do this sort of thing...
//Sets what happens on an tykepol's creation.
function tykepol_on_spawn(){
	THIS.set_action_allowed("tackle");
	THIS.set_action_allowed("tailwhip");
	THIS.set_action_allowed("supertyke");
	set_iv_stats();
}

//Sets what happens on an tykepol's level-up
function tykepol_on_level(){
	THIS.set_max_hp();
}

function tykepol_tackle(){


}

function tykepol_tailwhip(){


}