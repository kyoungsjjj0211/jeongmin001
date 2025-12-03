package project2.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import project2.dto.MaterialDto;

@MyDao
public interface MaterialDao {
	public int insertMaterial(MaterialDto dto);
	public int updateMaterial (MaterialDto dto);
	public int deleteMaterial (int materialid);
	public List<MaterialDto> MaterialList();
	public MaterialDto selectMaterial(int materialid);
	public int insert2Material(MultipartFile file, MaterialDto dto);
	public int update2Material(MultipartFile file, MaterialDto dto);
}
