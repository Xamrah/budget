package ru.xamrah.budget.domain;

public class TransactionDto {
    Long id;
    Type type;
    Long number;
    Long account;
    Long amount;
    Long category;
    String processingTime;
    Short status;

    public TransactionDto() {
    }

    public Long getId() {
        return this.id;
    }

    public Type getType() {
        return this.type;
    }

    public Long getNumber() {
        return this.number;
    }

    public Long getAccount() {
        return this.account;
    }

    public Long getAmount() {
        return this.amount;
    }

    public Long getCategory() {
        return this.category;
    }

    public String getProcessingTime() {
        return this.processingTime;
    }

    public Short getStatus() {
        return this.status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public void setProcessingTime(String processingTime) {
        this.processingTime = processingTime;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof TransactionDto)) return false;
        final TransactionDto other = (TransactionDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$type = this.getType();
        final Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
        final Object this$number = this.getNumber();
        final Object other$number = other.getNumber();
        if (this$number == null ? other$number != null : !this$number.equals(other$number)) return false;
        final Object this$account = this.getAccount();
        final Object other$account = other.getAccount();
        if (this$account == null ? other$account != null : !this$account.equals(other$account)) return false;
        final Object this$amount = this.getAmount();
        final Object other$amount = other.getAmount();
        if (this$amount == null ? other$amount != null : !this$amount.equals(other$amount)) return false;
        final Object this$category = this.getCategory();
        final Object other$category = other.getCategory();
        if (this$category == null ? other$category != null : !this$category.equals(other$category)) return false;
        final Object this$processingTime = this.getProcessingTime();
        final Object other$processingTime = other.getProcessingTime();
        if (this$processingTime == null ? other$processingTime != null : !this$processingTime.equals(other$processingTime))
            return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TransactionDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $type = this.getType();
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
        final Object $number = this.getNumber();
        result = result * PRIME + ($number == null ? 43 : $number.hashCode());
        final Object $account = this.getAccount();
        result = result * PRIME + ($account == null ? 43 : $account.hashCode());
        final Object $amount = this.getAmount();
        result = result * PRIME + ($amount == null ? 43 : $amount.hashCode());
        final Object $category = this.getCategory();
        result = result * PRIME + ($category == null ? 43 : $category.hashCode());
        final Object $processingTime = this.getProcessingTime();
        result = result * PRIME + ($processingTime == null ? 43 : $processingTime.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    public String toString() {
        return "TransactionDto(id=" + this.getId() + ", type=" + this.getType() + ", number=" + this.getNumber() + ", account=" + this.getAccount() + ", amount=" + this.getAmount() + ", category=" + this.getCategory() + ", processingTime=" + this.getProcessingTime() + ", status=" + this.getStatus() + ")";
    }
}
