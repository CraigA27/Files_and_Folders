package com.example.codeclan.filesandfolders.components;

import com.example.codeclan.filesandfolders.models.File;
import com.example.codeclan.filesandfolders.models.Folder;
import com.example.codeclan.filesandfolders.models.User;
import com.example.codeclan.filesandfolders.repositories.FileRepository;
import com.example.codeclan.filesandfolders.repositories.FolderRepository;
import com.example.codeclan.filesandfolders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    FileRepository fileRepository;
    @Autowired
    FolderRepository folderRepository;
    @Autowired
    UserRepository userRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {
        User user1 = new User("Bob");
        userRepository.save(user1);
        User user2 = new User("Bobette");
        userRepository.save(user2);
        Folder music = new Folder("music", user1);
        folderRepository.save(music);
        Folder docs = new Folder ("docs", user1);
        folderRepository.save(docs);
        Folder pictures = new Folder("pictures", user2);
        folderRepository.save(pictures);
        Folder work = new Folder("work_stuff", user2);
        folderRepository.save(work);
        File picture1 = new File("image_01", ".jpg", 4, pictures);
        fileRepository.save(picture1);
        File picture2 = new File("image_02", ".jpg", 3, pictures);
        fileRepository.save(picture2);
        File document2 = new File("very_important", ".txt", 2, work);
        fileRepository.save(document2);
        File song1 = new File("song1", ".mp3", 120, music);
        fileRepository.save(song1);
        File song2 = new File("song2", ".mp3", 150, music);
        fileRepository.save(song2);
        File document1 = new File("doc1", ".txt", 1, docs);
        fileRepository.save(document1);

        music.addFile(song1);
        music.addFile(song2);
        folderRepository.save(music);
        docs.addFile(document1);
        folderRepository.save(docs);
        pictures.addFile(picture1);
        pictures.addFile(picture2);
        folderRepository.save(pictures);
        work.addFile(document2);
        folderRepository.save(work);
        user1.addFolder(music);
        user1.addFolder(docs);
        userRepository.save(user1);
    }
}
