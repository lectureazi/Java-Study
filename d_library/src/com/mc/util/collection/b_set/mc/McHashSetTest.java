package com.mc.util.collection.b_set.mc;

import com.mc.util.collection.z_dto.Music;

public class McHashSetTest {

	public void studySet() {
		
		McHashSet<Music> musicSet = new McHashSet<>();
		musicSet.add(new Music("김경호", "금지된 사랑"));
		musicSet.add(new Music("김경호", "금지된 사랑"));
		musicSet.add(new Music("김경호", "금지된 사랑"));
		musicSet.add(new Music("김경호", "금지된 사랑"));
		musicSet.add(new Music("김경호", "와인"));
		musicSet.add(new Music("김경호", "화인"));
		musicSet.add(new Music("김경호", "바인"));
		
		System.out.println(musicSet);
		musicSet.remove(new Music("김경호", "바인"));
		System.out.println(musicSet);
		
	}
}
