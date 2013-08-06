function set_iv_stats(){
	THIS.set_iv_hp( Math.floor(Math.random()*31) + 1 );
	THIS.set_iv_attack( Math.floor(Math.random()*31) + 1 );
	THIS.set_iv_defense( Math.floor(Math.random()*31) + 1 );
	THIS.set_iv_sp_attack( Math.floor(Math.random()*31) + 1 );
	THIS.set_iv_sp_defense( Math.floor(Math.random()*31) + 1 );
	THIS.set_iv_speed( Math.floor(Math.random()*31) + 1 );
}