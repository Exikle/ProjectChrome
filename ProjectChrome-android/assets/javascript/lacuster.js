//This tells the game that "lacuster" should be a new pokemon type.
//In the code, it will be referenced as "lacuster.whatever"
//evolves to lacoyent / lakoient / laquoient
pokemon.register_pokemon("lacuster");

//Sets lacuster's images
lacuster.register_image_front(PATH.POKEMON_SPRITES_PATH + "/Cosmet.png"); //Temporary
lacuster.register_image_back(PATH.POKEMON_SPRITES_PATH + "/CosmetB.png"); //Temporary until Lacuster.png is found

//Sets lacuster's stats
//Using torchic stats //???
lacuster.set_type_name("lacuster");
lacuster.set_base_hp(45);
lacuster.set_base_attack(60);
lacuster.set_base_defense(40);
lacuster.set_base_sp_attack(70);
lacuster.set_base_sp_defense(50);
lacuster.set_base_speed(45);

lacuster.register_action("tackle" , "Tackle");
lacuster.register_action("leer" , "Leer");

//Hmm... maybe there should be a better way to do this sort of thing...
//Sets what happens on an lacuster's creation.
function lacuster_on_spawn(){
	THIS.set_type("Water");
	THIS.set_action_allowed("tackle");
	THIS.set_action_allowed("leer");
	set_iv_stats();
}

//Sets what happens on an lacuster's level-up
function lacuster_on_level(){
	THIS.set_max_hp();
}


function lacuster_tackle(){

}

function lacuster_leer(){

}