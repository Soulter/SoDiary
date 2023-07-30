package top.soulter.sodiary.service;

import top.soulter.sodiary.domain.Result;
import top.soulter.sodiary.domain.Diary;

import java.util.List;

public interface DiaryService {
    List<Diary> fetchDiary(int page, int size, boolean lock);
    Boolean submitDiary(Diary diary);
    Boolean updateDiary(Diary diary);
    Boolean deleteDiary(long id);
    Result fetchDiaryById(long id, boolean lock);

}
