"use client";

import React, { useEffect, useState } from "react";
import TopBar2 from "@/components/notifications/notifications-bar";
import {
  getMyNotifications,
  postReadNotification,
} from "@/components/notifications/notifications-ftn";
import { NotificationList } from "@/types/member";
import {
  Avatar,
  Button,
  List,
  ListItem,
  ListItemAvatar,
  ListItemText,
} from "@mui/material";
import Link from "next/link";
import { useRouter } from "next/navigation";

export default function MyNotificationsPage() {
  const [notifications, setNotifications] = useState<
    NotificationList["data"]["content"]
  >([]);
  const [data, setData] = useState<NotificationList["data"]>();
  const [page, setPage] = useState(0);
  const [success, setSuccess] = useState(true);
  const [today, setToday] = useState(new Date());
  const router = useRouter();

  const fetchData = async () => {
    const res = await getMyNotifications(page);
    setSuccess(res.success);
    // setNotifications(res.data.content);
    // 기존 데이터 유지하면서 새로운 데이터 추가
    setNotifications([...notifications, ...res.data.content]);
    setData(res.data);
    const date = new Date();
    setToday(date);
    console.log("res: ", res);
  };

  const formattedToday = (date: Date) => {
    const year = date.getFullYear();
    const month = date.getMonth() + 1;
    const day = date.getDate();
    const hour = date.getHours().toString().padStart(2, "0");
    const minute = date.getMinutes().toString().padStart(2, "0");
    return `${year}년 ${month}월 ${day}일 ${hour}:${minute}`;
  };

  const calculateDate = (date: Date) => {
    const diff = today.getTime() - date.getTime();
    if (diff >= 1000 * 3600 * 24) {
      const diffDays = (diff / (1000 * 3600 * 24)).toFixed(0);
      return `${diffDays}일 전`;
    } else if (diff >= 1000 * 3600) {
      const diffHours = (diff / (1000 * 3600)).toFixed(0);
      return `${diffHours}시간 전`;
    } else if (diff >= 1000 * 60) {
      const diffMinutes = (diff / (1000 * 60)).toFixed(0);
      return `${diffMinutes}분 전`;
    } else {
      return "방금 전";
    }
  };

  const handleLinkClick =
    (id: number, destination: string) => async (e: React.MouseEvent) => {
      e.preventDefault(); // 기본 동작 중단
      await postReadNotification(id); // API 요청
      // await new Promise((resolve) => setTimeout(resolve, 2000)); // 1초 대기
      router.push(destination); // 페이지 이동
    };

  useEffect(() => {
    fetchData();
  }, [page]);

  const handlePageMore = () => {
    setPage(page + 1);
  };

  return (
    <div>
      <TopBar2 />
      {success === false && <h3>알림을 불러오는 데 실패했습니다.</h3>}
      <List sx={{ width: "100%", minWidth: 260, bgcolor: "background.paper" }}>
        {success === true && data?.empty && (
          <>
            <ListItem sx={{ paddingX: 0, minHeight: "90px" }}>
              <ListItemAvatar>
                <Avatar
                  src="temp-img.svg"
                  alt="Temp Avatar"
                  sx={{ width: 48, height: 48, marginRight: 2 }}
                />
              </ListItemAvatar>
              <ListItemText
                primary="알림이 없습니다."
                secondary={formattedToday(today)}
              />
            </ListItem>
          </>
        )}
        {success === true && notifications.length > 0 && (
          <>
            {notifications.map((notification: any) => (
              <a
                key={notification.id}
                href={notification.destination}
                onClick={handleLinkClick(
                  notification.id,
                  notification.destination
                )}
                style={{ textDecoration: "none" }}
              >
                <ListItem sx={{ paddingX: 0, minHeight: "90px" }}>
                  <ListItemAvatar>
                    <Avatar
                      src={"temp-img.svg"}
                      alt="Notification Avatar"
                      sx={{ width: 48, height: 48, marginRight: 2 }}
                    />
                  </ListItemAvatar>
                  <ListItemText
                    primary={notification.message}
                    secondary={calculateDate(new Date(notification.sentAt))}
                  />
                </ListItem>
              </a>
            ))}
          </>
        )}
        {/* page*10 + 1 횟수만큼 반복(테스트용) */}
        {Array.from({ length: page * 10 + 1 }, (_, i) => (
          <a
            href="/"
            onClick={handleLinkClick(1, "/")}
            style={{ textDecoration: "none" }}
            key={i}
          >
            <ListItem sx={{ paddingX: 0, minHeight: "90px" }}>
              <ListItemAvatar>
                <Avatar
                  src="temp-img.svg"
                  alt="Temp Avatar"
                  sx={{ width: 48, height: 48, marginRight: 2 }}
                />
              </ListItemAvatar>
              <ListItemText
                primary="기능 테스트, 향후 지울 것. Browse through the icons below to find the one you need. The search field supports synonyms—for example, try searching for 'hamburger' or 'logout.'"
                secondary="2024년 1월 1일 09:00"
              />
            </ListItem>
          </a>
        ))}
      </List>
      <div className="flex justify-around mt-6">
        <Button
          onClick={handlePageMore}
          // disabled={data?.last || data?.empty}
          style={{
            // color: "black",
            fontSize: "1rem",
            fontWeight: "bold",
            padding: "0.5rem 1rem",
            // border: "1px solid black",
            borderRadius: "0.5rem",
            cursor: "pointer",
          }}
        >
          더 보기
        </Button>
      </div>
    </div>
  );
}