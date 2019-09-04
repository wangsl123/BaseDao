package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.SongMapper;
import model.Song;

@Service
public class SongServiceImpl extends BaseServiceImpl<Song> implements SongService{
	private SongMapper songMapper;

    @Autowired
	public void setSongMapper(SongMapper songMapper) {
		this.songMapper = songMapper;
		this.baseDao = songMapper;
	}
	
	

	
}
