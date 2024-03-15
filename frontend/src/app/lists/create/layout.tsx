import type { Metadata } from "next";


export function generateMetadata() {
    return {
      title: "Create Post",
      description: "Creating a post",
    };
  }

export default function ProductListLayout({
    children,
  }: {
    children: React.ReactNode
  }) {
    return (
        <div>
          {children}
        </div>
    )
  }