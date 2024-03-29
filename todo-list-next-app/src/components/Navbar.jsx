"use client";
import React from 'react'
import { useRouter } from 'next/navigation'
import Link from 'next/link';

function Navbar() {

    const router = useRouter();

    return (
        <header>
            <Link href="/">
                <h1>Task App</h1>
            </Link>

            <div>
                <button onClick={() => {
                    router.push(`/new`)
                }}>
                    Add Task
                </button>
            </div>
        </header>
    )
}

export default Navbar