package com.xiaoyixi.authcodelibrary;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author: XiaoYiXi
 * Create: 17-06-23.
 * Description: 自动填写短信中的验证码配置
 */

public class CodeConfig implements Parcelable {

    private int mCodeLen = 4;
    private String mSmsBodyStart;
    private String mSmsBodyContains;
    private long mSmsFrom;
    private int mSmsFromStart = 1069;

    public int getCodeLen() {
        return mCodeLen;
    }

    private void setCodeLen(int codeLen) {
        mCodeLen = codeLen;
    }

    public String getSmsBodyStart() {
        return mSmsBodyStart;
    }

    private void setSmsBodyStart(String smsStart) {
        mSmsBodyStart = smsStart;
    }

    public String getSmsBodyContains() {
        return mSmsBodyContains;
    }

    private void setSmsBodyContains(String smsContains) {
        mSmsBodyContains = smsContains;
    }

    public long getSmsFrom() {
        return mSmsFrom;
    }

    private void setSmsFrom(long smsFrom) {
        mSmsFrom = smsFrom;
    }

    public int getSmsFromStart() {
        return mSmsFromStart;
    }

    private void setSmsFromStart(int smsFromStart) {
        mSmsFromStart = smsFromStart;
    }

    public static class Builder {
        private long mSmsFrom;
        private int mSmsFromStart;
        private int mCodeLen;
        private String mSmsBodyStart;
        private String mSmsBodyContains;

        public Builder smsFrom(long phoneNumber) {
            mSmsFrom = phoneNumber;
            return this;
        }

        public Builder smsFromStart(int numberStart) {
            mSmsFromStart = numberStart;
            return this;
        }

        public Builder codeLength(int len) {
            mCodeLen = len;
            return this;
        }

        public Builder smsBodyStartWith(String startWith) {
            mSmsBodyStart = startWith;
            return this;
        }

        public Builder smsBodyContains(String contains) {
            mSmsBodyContains = contains;
            return this;
        }

        public CodeConfig build() {
            CodeConfig codeConfig = new CodeConfig();
            codeConfig.setSmsFrom(mSmsFrom);
            codeConfig.setSmsFromStart(mSmsFromStart);
            codeConfig.setCodeLen(mCodeLen);
            codeConfig.setSmsBodyStart(mSmsBodyStart);
            codeConfig.setSmsBodyContains(mSmsBodyContains);
            return codeConfig;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mCodeLen);
        dest.writeString(this.mSmsBodyStart);
        dest.writeString(this.mSmsBodyContains);
        dest.writeLong(this.mSmsFrom);
        dest.writeInt(this.mSmsFromStart);
    }

    public CodeConfig() {
    }

    protected CodeConfig(Parcel in) {
        this.mCodeLen = in.readInt();
        this.mSmsBodyStart = in.readString();
        this.mSmsBodyContains = in.readString();
        this.mSmsFrom = in.readLong();
        this.mSmsFromStart = in.readInt();
    }

    public static final Creator<CodeConfig> CREATOR = new Creator<CodeConfig>() {
        public CodeConfig createFromParcel(Parcel source) {
            return new CodeConfig(source);
        }

        public CodeConfig[] newArray(int size) {
            return new CodeConfig[size];
        }
    };
}
