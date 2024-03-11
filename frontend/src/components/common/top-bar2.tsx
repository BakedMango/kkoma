"use client";

import * as React from "react";
import Link from "next/link";
import { useRouter } from "next/navigation";
import Button from "@mui/material/Button"; // Material-UI 버튼 사용
import ArrowBackIcon from "@mui/icons-material/ArrowBack"; // Material-UI 뒤로 가기 아이콘

// 차후 각 페이지 별로 상단에 고정된 헤더를 만들기 위한 템플릿으로 사용합니다.
// 사용 예시
{/* 
    <div className="fixed top-0 left-0 w-full z-50">
        <TopBar2 />
    </div>
    <div className="px-4 mt-14">
        ...본문...
    </div> 
*/}
// import AppBar from "@mui/material/AppBar";
// AppBar 컴포넌트는 상단에 고정된 헤더를 만들 때 사용합니다.
// 그래서 이 컴포넌트에 쓰면 헤더가 중복이 되어 에러가 발생합니다.

export default function TopBar2() {
  const router = useRouter();
  return (
    <div className="bg-gray-800 text-white h-12 flex justify-between items-center px-4 top-0 left-0 right-0">
      <Button onClick={() => router.back()} startIcon={<ArrowBackIcon />}>
        뒤로 가기
      </Button>
      <span>페이지 타이틀</span>
      <div className="flex">
        <button className="bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded">
          알림
        </button>
      </div>
    </div>
  );
}