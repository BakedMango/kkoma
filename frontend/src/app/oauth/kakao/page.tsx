"use client";

import { useRouter, useSearchParams } from "next/navigation";
import { setItemWithExpireTime } from "@/utils/controlStorage";
import Loading from "@/components/common/loading";
import { kakaoLogin } from "@/services/kakaoLogin";
import LocalStorage from "@/utils/localStorage";
import { Token } from "@/types/token";

export default function KakaoOauth() {
  const router = useRouter();
  const searchParams = useSearchParams();

  const code = searchParams.get("code") ?? "";

  const doLogin = async () => {
    const res = await kakaoLogin(code);
    const obj = await res.json();

    setItemWithExpireTime("accessToken", obj.accessToken, obj.accessTokenExpireTime);
    setItemWithExpireTime("refreshToken", obj.refreshToken, obj.refreshTokenExpireTime);
    LocalStorage.setItem("grantType", obj.grantType);
  };

  try {
    doLogin();
    router.replace("/join/profile");
  } catch (e) {
    console.error(e);
    router.replace("/error");
  }

  return <Loading />;
}
