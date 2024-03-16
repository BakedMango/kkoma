"use client";

import styles from "@/components/my-page/my-profile.module.scss";
import Avatar from '@mui/material/Avatar';
import Link from "next/link";

export default function MyProfile() {
  return (
    <div className={styles.container}>
      <Avatar
        src="/chicken-home.svg"
        alt="Profile Image"
        // sx={{ width: 56, height: 56 }}
        className={`${styles.responsiveImg} mr-4`}
      />
      {/* 프로필사진이 없을 경우? */}
      {/* <Avatar {...stringAvatar('Kent Dodds')} /> */}
      <div className={`${styles.nickname} min-w-32 text-pretty mr-1 `}>
        <h4 className="">닉네임 닉네임 닉네임 닉네임 닉네임 닉네임</h4>
        <span className="text-slate-500">주소주소 주소주소 주소주소 주소주소 주소</span>
      </div>
      <Link href="/my-page/my-profile" passHref>
        <span className="text-center font-medium min-w-28 bg-gray-100 flex justify-center items-center py-1 rounded-lg cursor-pointer">
          프로필 보기
        </span>
      </Link>
    </div>
  );
}
