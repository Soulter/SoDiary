package top.soulter.sodiary.service;

import top.soulter.sodiary.domain.Result;
import top.soulter.sodiary.domain.Diary;

import java.util.List;

public interface DiaryService {
    List<Diary> fetchDiary();
}
