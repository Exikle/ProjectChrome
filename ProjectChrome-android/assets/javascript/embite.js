//This tells the game that "embite" should be a new pokemon type.
//In the code, it will be referenced as "embite.whatever"
pokemon.register_pokemon("embite");

//Sets embite's images
embite.register_image_front(PATH.POKEMON_SPRITES_PATH + "/Embite.png");
embite.register_image_back(PATH.POKEMON_SPRITES_PATH + "/EmbiteB.png");

//Sets embite's stats
//Using torchic stats //???
embite.set_type_name("Embite");
embite.set_base_hp(45);
embite.set_base_attack(60);
embite.set_base_defense(40);
embite.set_base_sp_attack(70);
embite.set_base_sp_defense(50);
embite.set_base_speed(45);

embite.set_types("Fire",  "xXx_blazer_prosniper_XL_xXx");

embite.register_action("tackle" , "Tackle");
embite.register_action("growl" , "Growl");

//Hmm... maybe there should be a better way to do this sort of thing...
//Sets what happens on an embite's creation.
function embite_on_spawn(){

	THIS.set_action_allowed("tackle");
	THIS.set_action_allowed("growl");
	set_iv_stats();
}

//Sets what happens on an embite's level-up
function embite_on_level(){
	THIS.set_max_hp();
}


function embite_tackle(){

}

function embite_leer(){

}